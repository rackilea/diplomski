public class Athlete
{

    private String name;
    private int age;
    private PhoneList phoneList;

    public Athlete(String name, int age)
    {
        this.name = name;
        this.age = age;
        phoneList = new PhoneList();

    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    // Maybe just return the toString (or a read only list)
    public PhoneList getPhones()
    {
        return phoneList;
    }

    publicvoid addPhone(String phone)
    {
        phoneList.add(phone);
    }


    @Override
    public String toString()
    {
        return "Athlete{" + "name=" + name + ", age=" + age + ", phones=" + phoneList + '}';
    }

    private class PhoneList
    {
        private ArrayList<String> list = new ArrayList<String>();

        private void add(String phone)
        {
            list.add(phone);
        }

        @Override
        public String toString()
        {
            StringBuffer b = new StringBuffer(32);

            for (String ph : list)
            {
                b.append(ph + "\n"); // Or something
            }

            return b.toString();
        }
    }

}