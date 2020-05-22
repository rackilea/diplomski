Given(/^there are results:$/) do |table|

  table.hashes.each do |s|

     sequence = Sequence.where(name: s[:sequence]).first
     result = FactoryGirl.build(:sequence_result)
     result.sequence = sequence._id.to_s
     result.user = User.where(name: s[:user]).first._id.to_s

     s[:steps].split(" ").each do |st|
        step = FactoryGirl.build(:step_result)

        parts = st.split(";")
        step.step = sequence.steps[parts[0].to_i]._id.to_s
        step.answer = parts[1]
        step.pass = parts[2] == "pass"

        result.step_results << step
     end

     result.save

  end

end