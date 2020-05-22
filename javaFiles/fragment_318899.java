boolean[] sameName = new boolean[emp.length];
...

// in the loop the if statement:
if ("David".equalsIgnoreCase(emp[i].getName()) && "Dave".equalsIgnoreCase(emp[i].getNickname()))
{
    sameName[i] = true;
}
else
{
    sameName[i] = false;
}    
...

// the output part:
System.out.println ("People with the same name and nickname : \n");
for (int i = 0; i < emp.length; i++) {
    if(sameName[i])
        System.out.println(emp[i]);
}