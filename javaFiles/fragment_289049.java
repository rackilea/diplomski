import java.util.Scanner;

public class Sanctuary {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

class Animal
    {
    private String species;
    private String animalname;
    private String breed;
    private double weight;
    private String gender;
    private int age;
    private String location;
    private String vet;
    private double vaccine;
    private double medicine;
    private double food;
    private double muandv;

        void GetAnimalData()           // Defining GetAnimalData()
        {

            Scanner sc = new Scanner(System.in);

            System.out.print("\n\tEnter Animal Species : ");
            species = (sc.nextLine());

            System.out.print("\n\tEnter Animal Name : ");
            animalname = sc.nextLine();

            System.out.print("\n\tEnter Animal Breed : ");
            breed = (sc.nextLine());

            System.out.print("\n\tEnter Animal Weight : ");
            weight = (sc.nextDouble());

            System.out.print("\n\tEnter Animal Gender : ");
            gender = (sc.nextLine());

            System.out.print("\n\tEnter Animal Age : ");
            age = Integer.parseInt(sc.nextLine());

            System.out.print("\n\tEnter Animal Location : ");
            location = (sc.nextLine());

            System.out.print("\n\tEnter Vet Name: ");
            vet = (sc.nextLine());

            System.out.print("\n\tEnter Vaccine Cost : ");
            vaccine = (sc.nextDouble());

            System.out.print("\n\tEnter Medicine Cost : ");
            medicine = sc.nextDouble();

            System.out.print("\n\tEnter Food Cost : ");
            food = (sc.nextDouble());

            System.out.print("\n\tEnter Maintenance, Utility and Vet Cost : ");
            muandv = (sc.nextDouble());

        }

        void PrintAnimalData()           // Defining PrintAnimalData()
        {
            System.out.print("\n\t" + species + "\t" +animalname + "\t" +breed + "\t" +weight + "\t" +gender + "\t" +age + "\t" +location + "\t" +vet + "\t" +vaccine + "\t" +medicine + "\t" +food + "\t" +muandv);
        }

        public void main(String args[])
        {



        }
}

Animal[] AnimalList = new Animal[100];
int i = 0;

for(i=0;i<AnimalList.length;i++)
    AnimalList[i] =  new Animal();   // Allocating memory to each object

for(i=0;i<AnimalList.length;i++)
{
    System.out.print("\nEnter details of "+ (i+1) +" Animal\n");
    AnimalList[i].GetAnimalData();
}

System.out.print("\nAnimal Details\n");
for(i=0;i<AnimalList.length;i++)
    AnimalList[i].PrintAnimalData();
    }
}