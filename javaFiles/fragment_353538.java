public void guardar(NodoAgenda nodo) throws IOException 
{
    FileWriter fich_s = new FileWriter("archivo.txt");
    BufferedWriter be = new BufferedWriter(fich_s);
    PrintWriter salida = new PrintWriter(be);
    if (nodo != null)
    {
        guardar(nodo.left, salida);
    }
    output.close();
}


public void guardar(NodoAgenda nodo, PrintWriter salida) throws IOException 
{
    if (nodo != null)
    {
        Parser p = new Parser();
        guardar(nodo.left);
        p.ponerPersona(nodo.info);
        String linea = p.obtainLine();
        salida.println(linea);
        guardar(nodo.right, salida);
        this.numNodes--;
    }
}