import scala.collection.Iterator;
import scala.runtime.BoxedUnit;

df.foreachPartition(new MyFunction1<Iterator<Row>,BoxedUnit>(){
        @Override
        public BoxedUnit apply(Iterator<Row> rows) {
            while(rows.hasNext()){
                //get the Row
                Row row = rows.next();
            }
            return BoxedUnit.UNIT;
        }
    });