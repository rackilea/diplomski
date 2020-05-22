// use an array, not a bunch of separate variables
int the_numbers[NUM_NUMBERS]; 

// here we assume you have filled in the numbers and validated
// that they are all in the range 0-9

bool duplicate_found = false;

bool seen[10] = { 0 };

for (int ii = 0; ii < NUM_NUMBERS; ++ii)
    if ( seen[ the_numbers[ii] ]++ )
    {
         duplicate_found = true;
         break;
    }