if (returnType instanceof ParameterizedType)
{
    System.out.println("Parameterized");
    ParameterizedType parameterized = (ParameterizedType) returnType;
    System.out.println(parameterized.getRawType().equals(List.class));
}
else
{
    System.out.println("Not parameterized");
    System.out.println(returnType.equals(List.class));
}