static Assembly^ MyResolveEventHandler( Object^ sender, ResolveEventArgs^ args )
{
    //Retrieve the list of referenced assemblies in an array of AssemblyName.
    Assembly^ MyAssembly;
    Assembly^ objExecutingAssemblies;
    String^ strTempAssmbPath = "";

    objExecutingAssemblies = Assembly::GetExecutingAssembly();
    array<AssemblyName ^>^ arrReferencedAssmbNames = objExecutingAssemblies->GetReferencedAssemblies();

    //Loop through the array of referenced assembly names.
    for each (AssemblyName^ strAssmbName in arrReferencedAssmbNames)
    {
        //Check for the assembly names that have raised the "AssemblyResolve" event.
        if (strAssmbName->FullName->Substring(0, strAssmbName->FullName->IndexOf(",")) == args->Name->Substring(0, args->Name->IndexOf(",")))
        {
            //Build the path of the assembly from where it has to be loaded.                
            strTempAssmbPath = pathBase + args->Name->Substring(0, args->Name->IndexOf(",")) + ".dll";
            break;
        }

    }
    //Load the assembly from the specified path.                    
    MyAssembly = Assembly::LoadFrom(strTempAssmbPath);

    //Return the loaded assembly.
    return MyAssembly;
}