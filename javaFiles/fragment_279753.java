import com.gams.api.GAMSWorkspace
    import com.gams.api.GAMSJob
    import com.gams.api.GAMSVariable
    import com.gams.api.GAMSVariableRecord
    import com.gams.api.GAMSWorkspace

    ws = GAMSWorkspace.new

    j1 = ws.addJobFromGamsLib('trnsport')

    j1.run

    j1.out_db.get_variable('x').each_entry do |rec|
      puts "x(#{rec.get_keys[0]}, #{rec.get_keys[1]}): level = #{rec.get_level},   marginal = #{rec.get_marginal}"
    end