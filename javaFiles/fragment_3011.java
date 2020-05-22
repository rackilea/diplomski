$ file_name="xyz_abc_diagnostics.wifi2.2015-07-30.12-30-52.tar.gz"
$ chk_regex='\.[0-9]+-[0-9]+-[0-9]+\.[0-9]+-[0-9]+-[0-9]+'
$ if [[ "$file_name" =~ $chk_regex  ]];then
> echo "in obs regex"
> else
> echo "dont triggered"
> fi
in obs regex