self.iamClient.create_role(RoleName=role_name, AssumeRolePolicyDocument={
                'Id': 'assume_role_id',
                'Statement': [
                {
                    'Principal': {
                        'Service': ['iot.amazonaws.com']
                    },
                    'Effect': 'Allow',
                    'Action': ['sts:AssumeRole']
                }
            ]
        }