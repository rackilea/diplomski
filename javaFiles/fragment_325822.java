ec2.describe_instances(
  filters:[
    {
      name: "instance-state-name",
      values: ["running"]
    }
  ]
).each do |resp|
  resp.reservations.each do |reservation|
    reservation.instances.each do |instance|
        puts instance.instance_id + " ---AND--- " + instance.public_ip_address
    end
  end
end