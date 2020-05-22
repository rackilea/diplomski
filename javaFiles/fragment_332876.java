// Iterate all values
for (int i = 0; i < nums.length; i++) {
    // Return true if value is not 1 OR not 3
    if (nums[i] != 1 || nums[i] != 3)
        return true;
}

// Return false
return false;