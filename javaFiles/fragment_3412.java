package sample;

import java.util.Random;

public class Person 
{
    private static final String[]   FIRST = {"Favonius", "Tim", "Brad", "Scott", "Linda"};
    private static final String[]   SECOND = {"Cruise", "Temp", "Abbey", "Adam", "Albert", "Thomas"};
    private static final String[]   COUNTRY = {"India", "USA", "Russia", "UK", "France", "Germany"};
    private static final int[]      AGE = {22, 23, 24, 25, 26, 27, 28, 29, 30};

    private static Random random = new Random(System.currentTimeMillis());

    private String first;
    private String second;
    private String country;
    private String likes;

    private int age;

    public Person(String first, String second, String country, String likes, int age) 
    {
        super();
        this.first = first;
        this.second = second;
        this.country = country;
        this.likes = likes;
        this.age = age;
    }
    public String getFirst() {
        return first;
    }
    public String getSecond() {
        return second;
    }
    public String getCountry() {
        return country;
    }
    public String getLikes() {
        return likes;
    }
    public int getAge() {
        return age;
    }
    public void setLikes(String likes) {
        this.likes = likes;
    }
    public static Person createRandomPerson(){
        return new  Person(FIRST[random.nextInt(FIRST.length)], 
                SECOND[random.nextInt(SECOND.length)], COUNTRY[random.nextInt(COUNTRY.length)], 
                "Y", AGE[random.nextInt(AGE.length)]);
    }
}