public static void main(String ... args)
{
    Map<UUID, String> mappings = new HashMap<>();
    mappings.put(UUID.fromString("47b58767-c0ad-43fe-8e87-c7dae489a4f0"), "+00112233445566778899");
    mappings.put(UUID.fromString("f9a1e8f4-b8c0-41f2-a626-49c11da8d5c2"), "someVirtualCompnayName");       

    Predefined predefined = new Predefined(
            UUID.fromString("47b58767-c0ad-43fe-8e87-c7dae489a4f0"), 
            UUID.fromString("f9a1e8f4-b8c0-41f2-a626-49c11da8d5c2"));
    Predefined predefined2 = new Predefined(
            UUID.randomUUID(), 
            UUID.fromString("f9a1e8f4-b8c0-41f2-a626-49c11da8d5c2"));
    Predefined predefined3 = new Predefined(
            null, 
            UUID.fromString("f9a1e8f4-b8c0-41f2-a626-49c11da8d5c2"));
    PredefinedValidator validator = new PredefinedValidator();

    System.out.println("predefined is valid: "+validator.validate(predefined, mappings));
    System.out.println("predefined is valid: "+validator.validate(predefined2, mappings));
    System.out.println("predefined is valid: "+validator.validate(predefined3, mappings));

    mappings.put(UUID.fromString("f9a1e8f4-b8c0-41f2-a626-49c11da8d5c2"), "someVirtualCompnayNamesomeVirtualCompnayNamesomeVirtualCompnayNamesomeVirtualCompnayName"); 
    System.out.println("predefined is valid: "+validator.validate(predefined, mappings));
}