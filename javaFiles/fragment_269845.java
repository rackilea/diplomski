item_id = <some_item_id>
  field_id = <contact_field_numeric_id>
  field_external_id = <contact_field_external_id>

  # set to empty value by field_id
  empty_value = []
  Podio::ItemField.update(item_id, field_id, single_value)

  # set to single value by field_id
  single_value = [{'value' => {'type' => 'user', 'id' => <Podio user id>}}]
  Podio::ItemField.update(item_id, field_id, single_value)

  # set to multiple values by external field id
  multi_values = [{'value' => {'type' => 'user', 'id' => <Podio user id>}}, 
                  {'value' => {'type' => 'user', 'id' => <another Podio user id>}}]
  Podio::ItemField.update(item_id, field_external_id, multi_values)