@Test
public void test(){
    Integer[] nums = {1,2,3,4,5};
    if(GenMethodDemo2.<Object,Integer>isIn("java",nums))
            System.out.println("java is in nums");
    if(!GenMethodDemo2.<Object,Integer>isIn("java",nums))
            System.out.println("java is not in nums");
}