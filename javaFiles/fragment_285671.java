insert into SYM_ROUTER 
  (router_id, source_node_group_id, target_node_group_id, router_type, 
    router_expression, create_time, last_update_time)
values
  ('erp_to_pdv__funcionario', 'erp', 'pdv', 'subselect', 
    'c.external_id in (
        select empresa.CNPJ
          from cadastro join empresa
            on cadastro.id_empresa = empresa.id_empresa
          where cadastro.CPFCGC=:ID_CADASTRO
     )', 
    current_timestamp, current_timestamp);