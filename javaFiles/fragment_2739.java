public class Project implements Comparable
{  
    static belongsTo = [employee:Employee]

    String name;

    static mapping = {
          roles lazy:false, cascade:"all,delete-orphan"
    }


    String toString()
    {
        return name
    }


    // compare by latest date of roles, then by name + id
    //if this is too intrusive, implement comparator with this logic and sort on rendering page
       int compareTo(obj) {
           if(obj == null){
               return 1;
           }


           return this.name.compareTo(obj.name);
       }

}

class Employee implements Comparable
{
    static hasMany = [projects:Project]

    String first, last
    static constraints = 
    {
    }

    static mapping = {
        projects cascade:"all,delete-orphan", lazy:false
    }

    SortedSet<Project> projects = new TreeSet<Project>();

    int compareTo(obj) {
        if(obj == null){
            return 1;
        }
           return this.name.compareTo(obj.name);
    }

}