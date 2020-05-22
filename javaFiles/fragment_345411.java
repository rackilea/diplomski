rule 'collect results'
  salience -500
  when
    $beans : ArrayList() from collect( MyBean() )
  then
    someGlobal.setBeans( $beans);
end