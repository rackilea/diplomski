@Override
public Object getValueAt(int arg0, int arg1) {
    switch (arg1) {
        case 0:
            return files[arg0].toString();
        case 1:
            return files[arg0].length();
        case 2:
            return new Date(files[arg0].lastModified());
    }
    return arg1;
}