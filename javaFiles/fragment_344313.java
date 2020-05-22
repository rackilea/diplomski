public List<Integer> spiralOrder(int[][] matrix) {
    if(matrix == null || (matrix.length == 0))
        return new ArrayList<Integer>();
    int arriba = 0;
    int derecha = matrix[0].length - 1;
    int abajo = matrix.length - 1;
    int izquierda = 0;
    List<Integer> retorno = new ArrayList<Integer>();
    while(true)
    {
        for(int i = izquierda; i <= derecha; i++)
            retorno.add(matrix[arriba][i]);
        arriba++;
        if(arriba > abajo)
            break;

        for(int i = arriba; i <= abajo; i++)
             retorno.add(matrix[i][derecha]);
        derecha--;
        if(izquierda > derecha)
            break;

        for(int i = derecha; i >= izquierda; i--)
            retorno.add(matrix[abajo][i]);
        abajo--;
        if(arriba > abajo)
            break;

        for(int i = abajo; i >= arriba; i--)
            retorno.add(matrix[i][izquierda]);
        izquierda++;
        if(izquierda > derecha)
            break;
    }
    return retorno;
}