final CriteriaBuilder builder = em.getCriteriaBuilder();
final CriteriaQuery<Foo> criteria = builder.createQuery(Foo.class);
Root<Foo> fromFoo = criteria.from(Foo.class);
Join<Foo, Bar> foobars = (Join) fromFoo.fetch("bars");

select
    foo0_.foo_id as foo_id1_2_0_,
    bar2_.bar_id as bar_id1_1_1_,
    foo0_._deleted_ as _deleted2_2_0_,
    foo0_.name as name3_2_0_,
    bar2_._deleted_ as _deleted2_1_1_,
    bar2_.foo_id as foo_id3_1_1_,
    bar2_.key as key4_1_1_,
    bar2_.value as value5_1_1_,
    bars1_.foo_id as foo_id3_1_0__,
    bars1_.bars_bar_id as bars_bar6_1_0__ 
from
    foo foo0_ 
inner join
    bar bars1_ 
        on foo0_.foo_id=bars1_.foo_id 
inner join
    bar bar2_ 
        on bars1_.bars_bar_id=bar2_.bar_id