public List<Criterion> mapToCriterion(Map<String, Object> params)
{
  if (params == null) return null;

  // convert the parameter map to a list of criterion
  List<Criterion> criterionList = new ArrayList<>(params.size());
  for (Map.Entry<String, Object> entry : params.entrySet())
    criterionList.add(Restrictions.eqOrIsNull(entry.getKey(), entry.getValue()));
  return criterionList;
}