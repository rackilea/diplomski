public static void main(String[] args)
{
    VMFParser vmfParser = null;
    try
    {
        vmfParser = new VMFParser("myFile.vmf");
        vmfParser.parse();

        // access the vmfParser for the hierarchy
        vmfParser.traverse();
    }
    catch (VMFParsingException vpe)
    {
        // do something here
        vpe.printStackTrace();
    }
    finally
    {
        // clean up...
    }
}