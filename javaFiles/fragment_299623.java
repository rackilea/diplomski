Map:
  type = MapType name=ID '=' ...;
MapType:
  {MapType} name='Map' '<' keyType=PlainType ',' valueType=ValueType '>';
PlainType returns Type:
  name = 'String' | name='int';
ValueType returns Type:
  MapType | PlainType | ValuePlainType;
ValuePlainType returns Type:
  name='float';