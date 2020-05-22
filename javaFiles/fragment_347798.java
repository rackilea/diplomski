SELECT  sub.Site_Code, sub.[Site], sub.[Utility], sub.[Meter Type],
        sub.[log_date],
        SUM(sub.[value]) as [value],
        SUM(sub.[Cost]) as [cost],
        SUM(sub.[CO]) as [CO],
        sub.[Meter Name], sub.[Units], sub.[Meter_ID],
        sub.[Parent], sub.[Meter_Description]
FROM    (
        SELECT EP.Site_Code AS [Site_Code], DB.[Site] AS [Site], DB.[Utility] AS [Utility], 
                CASE ? WHEN 'Raw' THEN dateadd(mi,datediff(mi,0,DB.[log_date]),0) 
                WHEN 'Hour'  THEN dateadd(hh,datediff(hh,0,DB.[log_date]),0)
                WHEN 'Day'   THEN dateadd(dd,datediff(dd,0,DB.[log_date]),0)
                WHEN 'Week'  THEN dateadd(wk,datediff(wk,0,DB.[log_date]),0)
                WHEN 'Month' THEN dateadd(mm,datediff(mm,0,DB.[log_date]),0)
                WHEN 'Year'  THEN dateadd(yy,datediff(yy,0,DB.[log_date]),0)                                                     
                ELSE DB.[log_date]
                END AS [log_date],
                CASE WHEN DB.[value] >= 0 THEN DB.[value] ELSE 0 END AS [value],
                CASE WHEN DB.[Cost] >=0 THEN DB.[cost] ELSE 0 END AS [Cost],
                CASE WHEN DB.[CO2] >=0 THEN DB.[CO2] ELSE 0 END AS [CO],
                MT.[Meter_type_name] AS [Meter Type],
                MN.[Meter_Name] AS [Meter Name],
                U.[Unit_Name] AS [Units],
                EP.EnergyPoint_ID AS [Meter_ID],
                EP.Parent_ID AS [Parent],
                EP.Meter_Description AS [Meter_Description] 
        FROM [dbo].[JOHN_Dashboard] DB
        INNER JOIN [dbo].[EnergyPoints] EP ON DB.[EnergyPoint_ID] = EP.[EnergyPoint_ID] 
        INNER JOIN [dbo].[Meter_Types] MT ON MT.[Meter_Type_ID] = EP.[Meter_Type_ID]
        INNER JOIN [dbo].[Meter_Names] MN ON MN.[Meter_Name_ID] = EP.[Meter_Name_ID]
        INNER JOIN [dbo].[Units] U ON U.[Unit_ID] = EP.[Unit_id]
        WHERE [log_date] >= ? AND [Log_Date] < DATEADD(DAY, 1, ?)
        AND ( ? IS NULL OR EP.Energypoint_ID = ?)
        ) sub
GROUP BY sub.Site_Code, sub.[Site], sub.[Utility], sub.[Meter Type],           
        sub.[Meter Name], sub.[Units], sub.[Meter_ID],
        sub.[Parent], sub.[Meter_Description], sub.[log_date];