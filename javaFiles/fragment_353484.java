curl -XPUT "http://localhost:9200/test_index"

curl -XPUT "http://localhost:9200/test_index/person/1" -d'
{
   "first_name": "Bob",
   "last_name": "Jones",
   "building_id": 1
}'

curl -XPUT "http://localhost:9200/test_index/person/2" -d'
{
   "first_name": "Bill",
   "last_name": "Smith",
   "building_id": 1
}'

curl -XPUT "http://localhost:9200/test_index/person/3" -d'
{
   "first_name": "Joe",
   "last_name": "Williams",
   "building_id": 2
}'

curl -XPUT "http://localhost:9200/test_index/person/4" -d'
{
   "first_name": "John",
   "last_name": "Taylor",
   "building_id": 2
}'

curl -XPUT "http://localhost:9200/test_index/person/5" -d'
{
   "first_name": "Taylor",
   "last_name": "Johnson",
   "building_id": 2
}'