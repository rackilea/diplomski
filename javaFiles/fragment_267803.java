String in_db;//assume it swimming(?x)
String user="swimming(duck)"; 

//next splitting it at the ( which will seperate the before and after ( in the string and save into array carrying first part in array[0] and rest in the array[1].
String in_dp_parts[]=in_db.split("\\(");
String user_parts[]=user.split("\\(");
// next match if the first parts of the two arrays are same then assign the rest of the first array to second one.
if(user_parts[0].equals(in_db_parts(0)))
{
  in_db[1]=user[1];//assign the user provided value to in_db ?x
}