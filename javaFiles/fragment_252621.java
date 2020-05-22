public class PipedFile {

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("C:/inputPiped.txt"));

        ArrayList<Person> list = new ArrayList<Person>();
        Person p = null;
        String readLine = br.readLine();
        while(readLine != null){
            String [] person = readLine.split("\\|");
            System.out.println(person.length);
            p = new Person();
            p.setAge(Integer.parseInt(person[0]));
            p.setFname(person[1]);
            p.setLname(person[2]);
            p.setCity(person[3]);
            list.add(p);
            readLine = br.readLine();
        }

        Collections.sort(list);

        FileOutputStream fout = new FileOutputStream("C:/ooo.txt");

        for(Person prsn : list){
            fout.write(prsn.toString().getBytes());
            fout.write('\n');
        }
        System.out.println("DONE");

    }

}

class Person implements Comparable<Person>{
    int age;
    String fname;
    String lname;
    String city;

    public int getAge() {
        return age;
    }



    public void setAge(int age) {
        this.age = age;
    }



    public String getFname() {
        return fname;
    }



    public void setFname(String fname) {
        this.fname = fname;
    }



    public String getLname() {
        return lname;
    }



    public void setLname(String lname) {
        this.lname = lname;
    }



    public String getCity() {
        return city;
    }



    public void setCity(String city) {
        this.city = city;
    }



    @Override
    public int compareTo(Person p) {

        if(this.age < p.age){
            return 1;
        }else if(this.age > p.age){
            return -1;
        }else{
            return this.fname.compareTo(p.fname);
        }

    }

    @Override
    public String toString() {
        return this.age + " | " + this.fname + " | " + this.lname + " | " + this.city ;
    }

}