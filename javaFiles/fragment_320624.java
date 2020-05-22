String delimiter = "";
for (float f: values)
    {
        builder.append(delimiter)
        delimiter = ", ";
        int a=(int) (f*255);
        builder.append(a);
    }