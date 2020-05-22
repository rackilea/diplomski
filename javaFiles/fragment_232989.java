SimplePerson _person;

Console.WriteLine ("Class {0} has the following methods:", _person.GetType().Name); 

foreach (var method in _person.GetType().GetMethods()){
    Console.WriteLine ("\t {0}", method.Name);
}