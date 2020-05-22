if(NewAdminStatus.isEmpty()) ps.setNull(1, Types.VARCHAR) else ps.setString(1, NewAdminStatus);
if(newAddress.isEmpty()    ) ps.setNull(2, Types.VARCHAR) else ps.setString(2, newAddress    );
if(NewPay.isEmpty()        ) ps.setNull(3, Types.VARCHAR) else ps.setString(3, NewPay        );
if(NewRole.isEmpty()       ) ps.setNull(4, Types.VARCHAR) else ps.setString(4, NewRole       );
if(NewBSB.isEmpty()        ) ps.setNull(5, Types.VARCHAR) else ps.setString(5, NewBSB        );
if(NewBank.isEmpty()       ) ps.setNull(6, Types.VARCHAR) else ps.setString(6, NewBank       );
if(NewBAN.isEmpty()        ) ps.setNull(7, Types.VARCHAR) else ps.setString(7, NewBAN        );
if(NewSAN.isEmpty()        ) ps.setNull(8, Types.VARCHAR) else ps.setString(8, NewSAN        );
if(NewSAC.isEmpty()        ) ps.setNull(9, Types.VARCHAR) else ps.setString(9, NewSAC        );