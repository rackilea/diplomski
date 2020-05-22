{
  "properties": {
    "network_id": { "get_resource": "private_net" },
    "fixed_ips": [
      {
        "subnet_id": { "get_resource": "private_subnet" }
      },
      {
        "subnet_id": { "get_resource": "private_subnet" }
      }
    ]
  }
}