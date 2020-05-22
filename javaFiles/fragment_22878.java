branch="${1:-master}"
has_upstream=true
remote="$(git config --get branch.$branch.remote)" || has_upstream=false
merge="$(git config --get branch.$branch.merge)" || has_upstream=false
if ! $has_upstream; then
    echo "branch $branch has no upstream"
else
    case "$remote" in
        .) echo "branch $branch tracks local branch $merge";;
        *) echo "branch $branch tracks $merge on $remote";;
    esac
fi