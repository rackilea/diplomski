Rental r1 = null; // <= this is where we'll store the found object

for(Resort re: resortList)
{
    if ( re.getResortCode().equals(resortCode)) {
        System.out.println(re.toString());
        r1 = re; // <= keep track of the one we found
    }
}

// now r1 contains the found object, or null if not found