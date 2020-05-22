create table pizza_structure
(
  pizza_id ... constraint fk_structure_pizza references pizza,
  ingredient_id ... constraint fk_structure_ingredient references ingredient,
  amount ...,
  constraint pizza_structure_pkey primary key (pizza_id, ingredient_id)
);