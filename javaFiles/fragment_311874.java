INPUT:
[{userId: 1, userTypeId: 101, userType: ASSEMBLE}
, {userId: 1, userTypeId: 102, userType: ASSEMBLE}
, {userId: 2, userTypeId: 103, userType: ARCHS}
, {userId: 3, userTypeId: 103, userType: ARCHS}
, {userId: 4, userTypeId: 104, userType: BAYLEAF}
, {userId: 4, userTypeId: 105, userType: BAYLEAF}
, {userId: 5, userTypeId: 106, userType: CHARSET}
]

OUTPUT:
[{userIds: [5], userTypeIds: [106], userType: CHARSET}
, {userIds: [1], userTypeIds: [101, 102], userType: ASSEMBLE}
, {userIds: [2, 3], userTypeIds: [103], userType: ARCHS}
, {userIds: [4], userTypeIds: [104, 105], userType: BAYLEAF}
]