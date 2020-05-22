public ComputerMicrobe reproduce (ComputerMicrobe otherComputerMicrobe)
{
    //Concatenated the the names of the two ComputerMicrobes
    String name = this.name + otherComputerMicrobe.getName();

    //Creates a DNACode consisting of 2 halves of the DNACode of the
    //two ComputerMicrobes
    String dnaCode = this.dNACode.substring(0, this.dNACode.length() / 2);
    dnaCode += otherComputerMicrobe.getDNACode().substring(dnaCode.length() - 1, otherComputerMicrobe.getDNACode().length();

    //Creates and returns the new ComputerMicrobe
    return new ComputerMicrobe(name, dnaCode);
}