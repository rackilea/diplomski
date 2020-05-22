public class TestGroup {

/**
 * @param args
 */
public static void main(String[] args) 
{

    Group group1 = new Group("123", "testers");
    Group group2 = new Group("456", "programmers");
    Group group3 = new Group("687", "students");

    GroupData groupData = new GroupData();

    groupData.add(group1);
    groupData.add(group2);
    groupData.add(group3);

    groupData.remove(group3);
}

}