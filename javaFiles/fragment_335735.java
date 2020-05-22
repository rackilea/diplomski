use strict;
use warnings;

open INFILE, "<infile" or die;
open OUTFILE, ">outfile" or die;
while(<INFILE>) {
  $_=~s/source-regex/replace-with/g;
  print OUTFILE;
}