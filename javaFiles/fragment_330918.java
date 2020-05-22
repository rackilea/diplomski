json={
  "test": [
    1,
    2,
    3,
    4
  ]
} 
read val=Wrap[test=[1, 2, 3, 4]]
val=Wrap[test=[0, 1, 2, 3, 4]]
json2={
  "test" : [ 0, 1, 2, 3, 4 ]
}