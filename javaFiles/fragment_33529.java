import collection.JavaConversions._
import com.googlecode.cqengine.query.QueryFactory._
import com.googlecode.cqengine.CQEngine;
import com.googlecode.cqengine.index.hash._;
import com.googlecode.cqengine.IndexedCollection;
import com.googlecode.cqengine.query.Query;
import java.util.Arrays.asList;

object CQTest {

  def main(args: Array[String]) {

    val cars: IndexedCollection[Car] = CQEngine.newInstance();
    cars.add(new Car(1, "Ford Focus", "great condition, low mileage", asList("spare tyre", "sunroof")));
    cars.add(new Car(2, "Ford Taurus", "dirty and unreliable, flat tyre", asList("spare tyre", "radio")));
    cars.add(new Car(3, "Honda Civic", "has a flat tyre and high mileage", asList("radio")));
    cars.add(new Car(4, "BMW M3", "2013 model", asList("radio", "convertible")));

    // add cruft to try and slow down CQE
    for (i <- 1 to 10000) {
      cars.add(new Car(i, "BMW2014_" + i, "2014 model", asList("radio", "convertible")))
    }

    // Create an indexed collection of garages...
    val garages: IndexedCollection[Garage] = CQEngine.newInstance();
    garages.add(new Garage(1, "Joe's garage", "London", asList("Ford Focus", "Honda Civic")));
    garages.add(new Garage(2, "Jane's garage", "Dublin", asList("BMW M3")));
    garages.add(new Garage(3, "John's garage", "Dublin", asList("Ford Focus", "Ford Taurus")));
    garages.add(new Garage(4, "Jill's garage", "Dublin", asList("Ford Focus")));

    // add cruft to try and slow down CQE
    for (i <- 1 to 10000) {
      garages.add(new Garage(i, "Jill's garage", "Dublin", asList("DONT_MATCH_CARS_BMW2014_" + i)))
    }

    println("Done adding data")
    // cars.addIndex(HashIndex.onAttribute(Car.NAME));
    // garages.addIndex(HashIndex.onAttribute(Garage.BRANDS_SERVICED));
    println("Done adding index")
    val query = existsIn(garages, Car.NAME, Garage.BRANDS_SERVICED, equal(Garage.LOCATION, "Dublin"))
    val resultSet = cars.retrieve(query)

    var previous = System.currentTimeMillis()
    println("============== Scala ============== ")
    // Scala version
    resultSet.foreach(r => {
      println(r);
      val t = (System.currentTimeMillis() - previous)
      System.out.println("Time : " + t / 1000 + " seconds")
      previous = System.currentTimeMillis()
    })

    println("============== Java ============== ")
    previous = System.currentTimeMillis()
    // Java version
    val i: java.util.Iterator[Car] = resultSet.iterator()
    while (i.hasNext) {
      val r = i.next()
      println(r);
      val t = (System.currentTimeMillis() - previous)
      System.out.println("Time : " + t / 1000  + " seconds")
      previous = System.currentTimeMillis()
    }
  }
}