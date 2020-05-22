for(int x = 0;x< 1000;x++){
    for (int i = 0; i < results.size(); i++)
    {
        for (int j = 0; j < simSource.size(); j++)
        {
            Value buffer = results.get(i);
            buffer.doubleField += (simSource.get(j) * 0.5)/3;
            //System.out.println(results.get(i) + (simSource.get(j) * 0.5)/3);
        }
    }
}