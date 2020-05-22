boolean found = false;
for(Person p1: personList)
        {
            if(p1.getName.equals(p.getName()))
            {
                if(p1.getBirthdayString.equals(p.getBirthdayString()))                            
                {
                    System.out.println("Information in record" +"\n" + "name: "+ p.getName() + "\n" + "Birthday: " + p.getBirthdayString() + "\n" +"has been updated");
                    p1.setEmail(p.getEmail());
                    p1.setPhone(p.getPhone());
                    p1.setAddress(p.getAddress());
                    FileIO.outData(personList, outputFileName);

                    found = true;
                 }

            }

        }
if (!found)
{
        System.out.println("New record has been added!");
        personList.add(p);
        FileIO.outData(personList, outputFileName); 
}