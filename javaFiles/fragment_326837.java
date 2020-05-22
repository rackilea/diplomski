f=$(dirname $0)/edit.txt
read -r i < "$f"
echo "session is: $i"

echo -n "file path is: "
sed '2q;d' "$f"