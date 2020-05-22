int resortIndex = -1; // <= this is where we'll store the index

for(int n = 0; n < resortList.size(); ++ n)
{
    if ( resortList.get(n).getResortCode().equals(resortCode)) {
        System.out.println(re.toString());
        resortIndex = n; // <= keep track of the index
    }
}

// now resortIndex contains the index into the array, or -1 if not found