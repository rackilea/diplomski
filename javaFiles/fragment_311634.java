use Archive::Zip;

my $zip = Archive::Zip->new("test.zip");
my $file_path = "test.txt";

my $PARANOID = 1;
if ($PARANOID) {
    my $file = $zip->memberNamed($file_path);
    unless ($file) {
        die "File '$file_path' not found in the archive";
    }
}

$zip->extractMember($file_path, "extracted_file.txt");