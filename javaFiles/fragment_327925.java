if (covDate != null && !covDate.equals("")) 
{
    String[] parts = covDate.split("\\n");
    for(int i=0;i<parts.length; i++){
        System.out.println("Date "+ i + " - "+parts[i])
    }
}
else{
    System.out.println("Dates Missing");
}