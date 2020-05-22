@Execute
void execute(EPartService partService)
{
  MPart part = partService.findPart("part id ");

  // TODO use FileDialog

  YourClass yourClass = (YourClass)part.getObject();

  // TODO call a method in YourClass to set the table input
}