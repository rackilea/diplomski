boolean prefixSuffixFound = false
for ( String prefixSuffix : namePrefixSuffixList ) {
     if(entry.getKey().toLowerCase().contains(prefixSuffix) {
          prefixSuffixFound = true;
          break;
     }
}