@RequestMethod("/fish")
public String fish(
    @ModelAttribute final Fish fish,
    final ModelMap model)
{
     return commonMethod(model, (Animal)fish);
}

@RequestMethod("/cat")
public String cat(
    @ModelAttribute final Cat cat,
    final ModelMap model)
{
     return commonMethod(model, (Animal)cat);
}

public String commonMethod(
    final ModelMap model,
    final Animal animal)
{
    ... blam
}