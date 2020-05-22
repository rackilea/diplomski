String hql = "SELECT new com.pizzaboy.dto.OrderDTO(o)"
    + " FROM Order o JOIN o.user u "
    + " JOIN FETCH o.deliveryType dt"
    + " JOIN FETCH o.restaurant r "
    + " JOIN FETCH o.dishes d"
    + " WHERE u.id=:id";