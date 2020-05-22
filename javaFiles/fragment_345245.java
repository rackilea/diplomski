for (int i = 0; i <= intarray.length - 1; i++) {
            outFile.print(intarray[i] + " ");
        }
        outFile.println(); // this is missing
    }
    outFile.close();